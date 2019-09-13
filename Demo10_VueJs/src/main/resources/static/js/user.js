new Vue({
    el: '#app',
    data: {
        userList: [],
        user:{}
    },
    //自定义方法
    methods:{
        //加载所有数据
        findAll:function () {
            //请求后台获取数据
            var url = 'http://localhost:8080/user/findAll';
            //先把外面的this存起来
            var _this = this;
            axios.get(url).then(function (resp) {
                //获取后台返回的数据
                var data = resp.data;
                //把返回的数据赋值给模型
                _this.userList = data;
            })
        },
        //回显数据
        findById:function (id) {
            //请求后台获取数据
            // var url = 'http://localhost:8080/user/findById?id=' + id;
            var url = 'http://localhost:8080/user/findById'
            //先把外面的this存起来
            var _this = this;
            axios.get(url,{
                params:{
                    id:id
                }
            }).then(function (resp) {
                //获取后台返回的数据
                var data = resp.data;
                //把返回的数据赋值给模型
                _this.user = data;
            })
            //弹出模态窗口
            $("#myModal").modal('show')
        },
        //修改数据
        update:function () {
            //请求后台获取数据
            var url = 'http://localhost:8080/user/update';
            //先把外面的this存起来
            var _this = this;
            axios.post(url,this.user).then(function (resp) {
                //刷新列表
                _this.findAll();
            })
        },


    },
    //调用生命周期方法
    created:function () {
        //调用findAll
        this.findAll();
    }
});
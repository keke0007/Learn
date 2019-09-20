package com.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/9/20 9:46
 */
public class Generator {

    @Test
    public void Generator() {
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)    //是否支持AR模式
                .setAuthor("ke")    //设置作者
                .setOutputDir("")   //设置生成目录
                .setFileOverride(true)  //是否文件覆盖
                .setIdType(IdType.AUTO) //主键策略
                .setServiceName("%sService")    //生成Service接口名字首字母是否为IXxx
                .setBaseResultMap(true) //设置自定义SQL
                .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)    //设置数据库的类型
                .setDriverName("com.mysql.jdbc.Driver") //设置数据库的驱动
                .setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8") //设置数据库的url
                .setUsername("root")    //用户名
                .setPassword("123456"); //密码

        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)   //全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)   //数据库到实体的命令策略
                .setTablePrefix("tb_")
                .setInclude("生成的表");    //生成的表

        //4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.mp")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6.执行
        ag.execute();

    }

}

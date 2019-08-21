import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportHSSFRichTextString {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\test.xls");
        if (file.exists()) {
            file.delete();
        }
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream("D:\\test.xls"));
            exportExcel(out);
        } finally {
            out.close();
        }
    }

    private static void exportExcel(BufferedOutputStream out) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("富文本");
        sheet.setColumnWidth(2, 150 * 256);
        Row row = sheet.createRow(5);
        Cell cell = row.createCell(2);

        CellStyle style = workbook.createCellStyle();
        cell.setCellStyle(style);
        HSSFRichTextString str = new HSSFRichTextString("富文本上标 字符串下标 水平删除线 下划线");

        /**********************************第一个字体Font:富文本0-3******************************************************/
        // 在workbook中创建一个字体
        Font font1 = workbook.createFont();
        // 设置字体为粗体
        font1.setBold(true);
        // 设置字体的字符集 - 默认字体集
        font1.setCharSet(Font.DEFAULT_CHARSET);
        // 设置字体的高度 - 以1pt的1/20位单位
        font1.setFontHeightInPoints((short) 40);
        // 设置字体的名字
        font1.setFontName("宋体");
        // 设置文字为斜体
        font1.setItalic(false);
        // 使用水平删除线
        font1.setStrikeout(true);
        // 设置字体颜色为默认黑色
        font1.setColor(Font.COLOR_RED);
        style.setFont(font1);

        /**********************************第二个字体Font: 上标3-5******************************************************/
        Font font2 = workbook.createFont();
        // 设置上标字体高度为30pt
        font2.setFontHeightInPoints((short) 20);
        // 设置为上标
        font2.setTypeOffset(Font.SS_SUPER);
        str.applyFont(3, 5, font2);

        /**********************************第三个字体Font: 字符串6-9******************************************************/
        Font font3 = workbook.createFont();
        // 设置字体高度 - 以1pt为单位, 设置字体为60pt
        font3.setFontHeightInPoints((short) 40);
        font3.setBold(true);
        // 设置字体的字符集 - ANSI字符集
        font3.setCharSet(Font.ANSI_CHARSET);
        // 设置字体颜色为深红色
        font3.setColor(Font.COLOR_RED);
        str.applyFont(6, 9, font3);

        /**********************************第四个字体Font: 下标9-11******************************************************/
        Font font4 = workbook.createFont();
        // 设置为下标
        font4.setTypeOffset(Font.SS_SUB);
        // 设置下 标字体高度为30pt
        font4.setFontHeightInPoints((short) 20);
        str.applyFont(9, 11, font4);

        /**********************************第五个字体Font: 水平删除线12-17******************************************************/
        Font font5 = workbook.createFont();
        // 设置下 标字体高度为30pt
        font5.setFontHeightInPoints((short) 30);
        font5.setColor(Font.COLOR_RED);
        font5.setStrikeout(true);
        str.applyFont(12, 17, font5);

        /**********************************第六个字体Font: 下划线18-21******************************************************/
        Font font6 = workbook.createFont();
        // 设置下 标字体高度为30pt
        font6.setFontHeightInPoints((short) 30);
        font6.setColor(Font.COLOR_RED);
        font6.setItalic(true);
        // 设置字体双下划线
        font6.setUnderline(Font.U_DOUBLE);
        str.applyFont(18, 21, font6);

        cell.setCellValue(str);
        workbook.write(out);
    }
}

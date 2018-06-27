package cn.vpclub.demo.common.model.utils.constant;

/**
 * 文件后缀名常量类
 * 小写的后缀名以“后缀名_SUFFIX”命名
 * 大写的后缀名以“U_后缀名_SUFFIX”命名
 *
 * @author HJ
 */
public class FileSuffixNameConstant {
    private FileSuffixNameConstant() {

    }

    /**
     * EXCEL 2003的后缀名(小写)：.XLS
     */
    public static final String XLS_SUFFIX = ".xls";

    /**
     * EXCEL 2003的后缀名(大写)：.XLS
     */
    public static final String U_XLS_SUFFIX = ".XLS";

    /**
     * EXCEL 2007的后缀名(小写)：.XLSX
     */
    public static final String XLSX_SUFFIX = ".xlsx";

    /**
     * EXCEL 2007的后缀名(大写)：.XLSX
     */
    public static final String U_XLSX_SUFFIX = ".XLSX";
}

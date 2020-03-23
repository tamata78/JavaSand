package fw.sastruts;

import java.io.PrintWriter;

import javax.annotation.Resource;

public class RequesSand {
	// HttpServletRequestやHttpServletResponseなどのServlet API関連のオブジェクト
    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Resource
    protected HttpSession session;

    @Resource
    protected ServletContext application;

    // Action処理
    @Execute
    public String order() {
        // メイン処理


        // 注文連携結果を返却
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("注文が完了しました");
            out.flush();
        } finally {
            if (null != out) {
                out.close();
            }
        }

        return null; // 遷移先、未指定
    }

    @Execute(urlPattern = "edit/{id}") // urlとパラメータ指定
    public String edit() {
        // メイン処理

        return null; // 遷移先、未指定
    }

}

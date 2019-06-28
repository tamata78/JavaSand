package message;

import java.io.PrintWriter;

public class MessageSandbox {

	public static void main(String[] args) {
		// データをJSON化してレスポンスを呼び出し元に返却
		PrintWriter out = null;
		try {
			String contents = "";
			response.setContentType("application/json; charset=UTF-8");
			out = response.getWriter();
			// 出力
			out.print(contents);
			out.flush();
		} finally {
			if (null != out) {
				out.close();
			}
		}

		// 例外発生させてメッセージ送付
		//throw new ProccessException(ResUtil.getProccessStr(
		//	"errors.group.code", optionGroupCd));

		// org.seasar.struts.util.ActionMessagesUtil.addErrorsを用いてメッセージ送付
		// addError(new ActionMessage("errors.order_register"));
		// ActionErrors errors = new ActionErrors();
		// errors.add(EMPTY_STR, am);
		// ActionMessagesUtil.addErrors(request, errors);

	}

}

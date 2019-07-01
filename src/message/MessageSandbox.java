package message;

public class MessageSandbox {

	public static void main(String[] args) {
		// レスポンスに設定してメッセージ送付
//		Response response;
//		PrintWriter out = null;
//		try {
//			String contents = "";
//			response.setContentType("application/json; charset=UTF-8");
//			out = response.getWriter();
//			// 出力
//			out.print(contents);
//			out.flush();
//		} finally {
//			if (null != out) {
//				out.close();
//			}
//		}

		// 例外発生させてメッセージ送付
		// throw new ProccessException(ResUtil.getProccessStr(
		// "errors.group.code", code));

		// org.seasar.struts.util.ActionMessagesUtil.addErrorsを用いてメッセージ送付
		// ActionMessage actionMessage = addError(new
		// ActionMessage("errors.order_register"));
		// ActionErrors errors = new ActionErrors();
		// errors.add("", actionMessage);
		// ActionMessagesUtil.addErrors(request, errors);

	}

}

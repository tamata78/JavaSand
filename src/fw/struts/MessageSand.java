package fw.struts;

import java.util.Iterator;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

/**
 * Struts1系 (サポート切れのため、推奨されない)
 *
 */
public class MessageSand {

  public static void main(String[] args) {
  //エラーメッセージの作成
    ActionErrors errors = new ActionErrors();;
    errors.add("TEST",new ActionMessage("エラーメッセージ１"));
    errors.add("TEST",new ActionMessage("エラーメッセージ２"));

    //エラーメッセージの取得
    if(errors != null && errors.size() > 0){
        if(errors.get().hasNext()){
            String str = ((ActionMessage) errors.get().next()).getKey();
        }
    }

    //繰返し取得したい場合
    Iterator<ActionMessage> iterator = errors.get();
    while(iterator.hasNext()){
        ActionMessage actionMessage = ((ActionMessage) iterator.next());
        String str = actionMessage.getKey();
    }

  }

}

package String;

import resource.ResourceUtils;

public class StringUtils {
    /** 禁則文字. **/
    private static final String INVALID_CHARACTER = "invalid.character";


    /**
     * 禁則文字チェック
     *
     * @param targetStr
     * @return 禁則文字あり：false 禁則文字なし:true
     */
    private static boolean checkProhibitedChars(String targetStr) {
        String prohibitedChars = ResourceUtils.getPropertiesVal(INVALID_CHARACTER);
        new StringBuilder("[").append(prohibitedChars).append("]+");

        // charAtは、機種依存文字(≒サロゲートペア)を考慮できない
//        for(int i = 0; i < targetStr.codePointCount(0, targetStr.length()); i++) {
//            char targetChar = targetStr.charAt(i);
//
//            for (int prohibitedIndex = 0; prohibitedIndex < prohibitedChars.length(); prohibitedIndex++) {
//                if(targetChar.equals(prohibitedChars.charAt(prohibitedIndex))) {
//
//                }
//            }
//
//        }


        return true;

    }

}

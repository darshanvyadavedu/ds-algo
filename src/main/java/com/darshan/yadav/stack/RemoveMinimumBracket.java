package com.darshan.yadav.stack;

public class RemoveMinimumBracket {
    public String minRemoveToMakeValid(String s) {

        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') count++;
            else if(ch ==')') {
                if(count == 0) continue;
                count--;
            }
            sb.append(ch);
        }
        if(count > 0){
            for(int i = sb.length()-1; i>= 0; i--){
                if(sb.charAt(i) == '('){
                    sb.deleteCharAt(i);
                    count--;
                    if(count == 0) break;
                }
            }
        }
        return sb.toString();
    }
}

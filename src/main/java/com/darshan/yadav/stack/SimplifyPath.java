package com.darshan.yadav.stack;

public class SimplifyPath {
    public static void main(String[] args) {

    }

    // Short sited view algorithm
    // here I check only i+1 index is .. then i will not write current directory
    // what happens if i have a directory like /a/b/c/../d/e/.. then it will not work
    // that is the reason I should used stack
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< dir.length; i++){
            String curr = dir[i];
            if(curr == null || curr.length() == 0) continue;
            if(curr.equals(".") || curr.equals("..")) continue;
            if(i+1 < dir.length){
                if("..".equals(dir[i+1])) continue;
            }
            sb.append("/");
            sb.append(curr);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

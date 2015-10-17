/*
	Given an integer, convert it to a roman numeral.

	Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public String intToRoman(int num) {
        Stack st = new Stack();
        int base = 10;
        while(num != 0){
            int res = num % 10;
            num = num / 10;
            if(base == 10){
               switch(res){
                   case 1: st.push('I'); break;
                   case 2: st.push("II"); break;
                   case 3: st.push("III"); break;
                   case 4: st.push("IV"); break;
                   case 5: st.push('V'); break;
                   case 6: st.push("VI"); break;
                   case 7: st.push("VII"); break;
                   case 8: st.push("VIII"); break;
                   case 9: st.push("IX"); break;
               }
            }
            else if(base == 100){
               switch(res){
                   case 1: st.push('X'); break;
                   case 2: st.push("XX"); break;
                   case 3: st.push("XXX"); break;
                   case 4: st.push("XL"); break;
                   case 5: st.push('L'); break;
                   case 6: st.push("LX"); break;
                   case 7: st.push("LXX"); break;
                   case 8: st.push("LXXX"); break;
                   case 9: st.push("XC"); break;
               }
            }
            else if(base == 1000){
                 switch(res){
                   case 1: st.push('C'); break;
                   case 2: st.push("CC"); break;
                   case 3: st.push("CCC"); break;
                   case 4: st.push("CD"); break;
                   case 5: st.push('D'); break;
                   case 6: st.push("DC"); break;
                   case 7: st.push("DCC"); break;
                   case 8: st.push("DCCC"); break;
                   case 9: st.push("CM"); break;
               }
            }
            else if(base == 10000){
                 switch(res){
                   case 1: st.push('M'); break;
                   case 2: st.push("MM"); break;
                   case 3: st.push("MMM"); break;
               }
            }
            base = base * 10;
        }
        String ans = new String();
        while(!st.empty()){
            ans = ans + st.peek();
            st.pop();
        }
        return ans;
    }
}
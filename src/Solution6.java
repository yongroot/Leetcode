package leecode;

/**
 * 6. Z 字形变换
 */
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR") );
        System.out.println(solution6.convert("ABCD",2).equals("ACBD") );
    }

    public String convert(String s, int numRows) {
        if (s.length() <=2 || numRows <=1)
            return s;
        char[] source = s.toCharArray();

        StringBuilder[] coll = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            coll[i] = new StringBuilder();
        }

        int rowNum = 0;
        int face = 1;

        coll[0].append(source[0]);
        for (int i = 1; i < source.length; i++) {
            rowNum += face;
            coll[rowNum].append(source[i]);
            if (rowNum==0||rowNum == numRows-1){
                face = -face;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder cb : coll) {
            sb.append(cb);
        }
        return sb.toString();
    }

    public String convert3(String s, int numRows) {
        char[] chars = s.toCharArray();

        int subSize = numRows+numRows-2;
        int index = 0;
        int[] indexArr = new int[chars.length];
        for (int i = 0; i < chars.length; i += subSize) {
            indexArr[index++] = i;
        }
        for (int i = 0; i < numRows; i++) {

        }
        for (int i = 0; i <= index; ) {
            int n = indexArr[i]-1;
            int m = indexArr[i++]+1;
            if (n > 0) {
                indexArr[index++] = n;
            }
            if (n == m) {
                continue;
            }
            if (m < indexArr.length) {
                indexArr[index++] = m;
            }
            if (index == indexArr.length)
                break;
        }


        char[] result = new char[chars.length];
        index = 0;
        for (int i : indexArr) {
            result[index] = chars[i];
        }
        return new String(result);
    }

    public String convert2(String s, int numRows) {
        if (s.length()<=2 || numRows == 1)
            return s;
        int rowLength =  (int)(s.length()/(numRows-1))+(s.length()%(numRows-1)==0?0:1);
        char[][] tmp = new char[numRows/*纵长*/][rowLength/*行宽*/];
        char[] chars = s.toCharArray();

        int x = 0, y = 0;
        boolean isLong = true;
        for (char c : chars) {
            if (isLong) {
                tmp[y++][x] = c;

                if (y == tmp.length) {
                    x++;
                    isLong = false;
                    y -=(numRows==2?1:2);
                }
            } else {
                tmp[y--][x] = c;
                if (y == 0) {
                    x++;
                    isLong = true;
                }
            }
        }

        int cIndex = 0;
        x = 0;
        y = 0;
        while (true){
            char v = tmp[y][x++];
            if (v != '\u0000') {
                chars[cIndex++] = v;
            }
            if (x == rowLength) {
                x = 0;
                y++;
                if (y == tmp.length) {
                    break;
                }
            }
        }

        return new String(chars);

    }
}
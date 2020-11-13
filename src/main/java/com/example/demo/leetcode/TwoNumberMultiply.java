package com.example.demo.leetcode;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串
// 👍 487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class TwoNumberMultiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
//        结果最大长度也就是两个字符串长度之和
        int[] res = new int[char1.length + char2.length];
        int index1 = 0;
        int index2 = 0;
        int sum = 0;
        for (int i = char2.length-1; i >= 0; i--) {
            int key1 =(char2[i] - '0');
            for (int j = char1.length - 1; j >= 0; j--) {
                int mult =  key1* (char1[j] - '0');
                index1 = i + j;
                index2 = i + j + 1;

                sum = mult + res[index2];
                res[index2] = sum % 10;
                res[index1] += sum / 10;
            }
        }
//        最后处理下字符串前面可能为0的问题
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i] + "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new TwoNumberMultiply().multiply("123", "456"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package org.example.problems;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        var carry = '0';
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            var tempResult = new InnerAddBinary('0', '0');
            if (i >= 0 && j >= 0) {
                tempResult = add3Binaries(a.charAt(i), b.charAt(j), carry);
                carry = tempResult.carry;
            }
            if (i >= 0 && j < 0) {
                tempResult = add3Binaries(a.charAt(i), '0', carry);
                carry = tempResult.carry;
            }
            if (i < 0 && j >= 0) {
                tempResult = add3Binaries('0', b.charAt(j), carry);
                carry = tempResult.carry;
            }
            // result.append(tempResult.sum);
            result.insert(0, tempResult.sum);
            if (i == 0 && j == 0 && carry == '1')
                result.insert(0, tempResult.sum);
            i--;
            j--;
        }
        return result.toString();
    }

    private InnerAddBinary add3Binaries(char a, char b, char carry) {
        var result = '0';
        switch (carry) {
            case '0':
                switch (a) {
                    case '0':
                        switch (b) {
                            case '0':
                                result = '0';
                                carry = '0';
                                break;
                            case '1':
                                result = '1';
                                carry = '0';
                                break;
                            default:
                                break;
                        }
                        break;
                    case '1':
                        switch (b) {
                            case '0':
                                result = '1';
                                carry = '0';
                                break;
                            case '1':
                                result = '0';
                                carry = '1';
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case '1':
                switch (a) {
                    case '0':
                        switch (b) {
                            case '0':
                                result = '1';
                                carry = '0';
                                break;
                            case '1':
                                result = '0';
                                carry = '1';
                                break;
                            default:
                                break;
                        }
                        break;
                    case '1':
                        switch (b) {
                            case '0':
                                result = '0';
                                carry = '1';
                                break;
                            case '1':
                                result = '1';
                                carry = '1';
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return new InnerAddBinary(result, carry);
    }

    class InnerAddBinary {
        char sum, carry;

        public InnerAddBinary(char sum, char carry) {
            this.sum = sum;
            this.carry = carry;
        }
    }
}

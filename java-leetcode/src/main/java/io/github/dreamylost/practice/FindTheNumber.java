/* All Contributors (C) 2020 */
package io.github.dreamylost.practice;

/**
 * Title: FindTheNumber.java
 *
 * <p>Description:这是《编程之美》的2.20题目，给出一段C#代码，要求不用电脑，理解程序并回答问题。 下面是从C#代码中改写成的Java代码：
 *
 * <p>Copyright: Copyright (c) 2018
 *
 * <p>School: jxnu
 *
 * @question1 输出的i是什么
 * @question2 这种数是否存在，存在找到最小值
 * @question3 估算运行时间
 * @author Mr.Li
 * @date 2018-2-14
 * @version 1.0
 */
public class FindTheNumber {

    /**
     * @description 只需要给2-31这30个数分解质因数，找一下是否有这样的相邻的两个数， 要么它们的质因子中有其它数没有的质因子，要么对于相同的一个质因子，
     *     这两个数包含这个质因子的次数高于其它所有次数。 16、17、19、23、25、27、29、31这几个数包含次数最高的质因子。
     *     而相邻的则只有16，17。所以，这段程序所要求的数i就是 ，它不能被16、17整除，但能被30个数中的其它28个数整除，最小的i就是其它28个数的最小公倍数
     *     ，从上表中知道，这个最小的i是：23*33*52*7*11*13*19*23*29*31，
     * @note 要估算时间，我们先确定一个原子操作（或者说原子过程更合适）， 这里我们取内层for循环里的整个if语句块，该段程序主要包括一个取模操作和一个判断，
     *     如果进入if语句的话，还包括1次加法操作，1~2次判断和一次赋值操作。
     * @param args
     */
    /**
     * @answer 估算时间 我们知道加法、判断等操作基本都在几个时钟周期内就可以完成，而除法操作却需要数十个时钟周期，
     *     而取模操作也是通过除法操作得到的(还记得汇编语言里，执行除法操作之后，一个寄存器里存结果，另一个寄存器里存余数)，
     *     另外，对64位整数的除法明显要慢于32位整数，综合这些因素，我们可以假设该原子操作需要100个时钟周期。 因此2GHz的CPU在A1秒内能跑2*10^9 / 100 =
     *     2*10^7 即2000万次原子操作，做过ACM的同学就会有一个直观概念， 这和我们通常做时限为1S的题时估算的计算次数差不多。
     *     接下来估算原子操作执行的次数：外层循环跑了2123581660200次，内层循环取决于 i 的情况，
     *     当i为奇数的时候，内层最多跑5次即可结束，因为2，4，6都不能整除奇数；当i为偶数的时候，
     *     情况要复杂一些，但是也可以一个一个的详细分析。这里我们粗略估计，就算内层循环平均可以跑10次， 外层循环少跑一些，去掉零头，总的原子操作执行了2*10^13次。 所以需要
     *     2*10^13 / (2*10^7) = 10^6秒约为277个小时。 *
     */
    public static void main(String[] args) {
        int rg[] = {
            2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
            26, 27, 28, 29, 30, 31
        };
        for (long i = 1; i < Integer.MAX_VALUE; i++) {
            int hit = 0;
            int hit1 = -1;
            int hit2 = -1;
            for (int j = 0; j < rg.length && (hit <= 2); j++) {
                // hit==2表示这个条件只能被满足两次，也就是说对于一个i，在rg数组的30个数中，
                // 这个i能被其它28个数整除，而不能被其中两个数整除。
                if ((i % rg[j]) != 0) {
                    // hit表示满足i%r[j]!=0的条件的次数
                    hit++;
                    if (hit == 1) {
                        // 而hit1表示第一个不能整除i的数的下标
                        hit1 = j;
                    } else if (hit == 2) {
                        // hit2表示第二个不能整除i的下标
                        // 这两个下标被要求相差只有1
                        hit2 = j;
                    } else break;
                }
            }
            // 于是，程序所要寻找的是这样的数：这个数i不能被2-31这30个数中的两个相邻的数整除，
            // 但能被其它28个数整除。
            if ((hit == 2) && (hit1 + 1 == hit2)) {
                System.out.println("found i:" + i);
                break;
            }
        }
    }
}

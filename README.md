HashMap<String, Int> h = new HashMap<>()

Queue <Int> q = new LinkedList<>()
       
Stack <Int> s = new Stack<>()
       

//创建数组的第一种方法
int[] arr=new int[6];

//创建数组的第二种方法
int[] x={1,2,3,4};

//创建数组的第三种方法。
int[] y= new int[]{1,2,3,4,5};
       
# algorithm-exercise

本项目包含一些有意思的面试题以及他们的实现思路。

1 . **找出一个先升后降数组的最大元素。不要用递归。**

例：
输入：a = {1, 2, 3, 4, 4, 3, 2}

输出： 4

复杂度 o(logn)

注意：任何地方都可能有重复元素，原则是重复元素尽量跳过，采用二分法判断左边和右边，哪边包含最大的值。还有边缘case，比如最大值连续几个的问题

2 . **实现一个函数，对任意句子s，将其中的单词反转处理。**

句子中的单词通过空格符来分隔，所有非空格符均可认为是单词的一部分。注意单词间的空格可以连续多个。我们只需关注处理之后单词反转即可，至于空格数量无所谓。

说明：不可以使用字符串的split, replace之类的方法，需要自己来实现。空间复杂度越小越好。

例：
输入：
s = "this is an example"

处理完之后s变成：

s = "example an is this"

3 . **给出一个数组，数组中的数字皆为正整数，除了某一个数字，其他的数字都会出现三次。 找出那个只出现一次的数。**

思路：
如果是两个相同的就可以利用两个相同的数异或结果为0来计算的，但这个题目中其他数字是出现了3次，因此肯定不可以再使用异或了。

我们换一个角度来看，如果数组中没有x，那么数组中所有的数字都出现了3次，在二进制上，每位上1的个数肯定也能被3整除。如{1, 5, 1, 5, 1, 5}从二进制上看有：

1：0001

5：0101

1：0001

5：0101

1：0001

5：0101

二进制第0位上有6个1，第2位上有3个1.第1位和第3位上都是0个1，每一位上的统计结果都可以被3整除。而再对该数组添加任何一个数，如果这个数在二进制的某位上为1都将导致该位上1的个数不能被3整除。因此通过统计二进制上每位1的个数就可以推断出x在该位置上是0还是1了，这样就能计算出x了。

推广一下，所有其他数字出现N（N>=2）次，而一个数字出现1次都可以用这种解法来推导出这个出现1次的数字。

4 . **该函数是一个内存拷贝函数**

原型： void memcpy(void* dest, const void* src, unsigned int size)

功能：由src所指内存区域赋值size个字节到dest所指向内存区域

说明：src和dest所指内存区域有可能重叠，函数返回指向dest的指针

提示：两个内存区域有交集，说明他们有一段区域是重叠的。要么dest在src内存区域上，要么src在dest区域上。

5 . **输入两个整数，要求输出这两个数的乘积。输入的数字可能超过计算机内整形数据的存储范围。**

分析：由于数字无法用一个整形变量存储，很自然的想到用字符串来表示一串数字。然后按照乘法的运算规则，用一个乘数的每一位乘以另一个乘数，然后将所有中间结果按正确位置相加得到最终结果。可以分析得出如果乘数为A和B，A的位数为m，B的位数为n，则乘积结果为m+n-1位（最高位无进位时）或m+n位（最高位有进位）。因此可以分配一个m+n的辅存来存储最终结果。为了节约空间，所有的中间结果直接在m+n的辅存上进行累加。最后为了更符合我们的乘法运算逻辑，可以将数字逆序存储，这样数字的低位就在数组的低下标位置，进行累加时确定下标位置较容易些。

扩展：相减，相加，除法

6 . **两个单向有序链表合并，时间复杂度o(m+n)，空间复杂度o(1)**
    思路：把一个链表的元素插入到另一个链表中合适的位置（涉及查找逻辑的不同），只是两个链表需要同时遍历（有序的特点）。最后返回被插入的链表头结点

7 . **一个单向链表，每个节点有各两个指针，一个指针指向下一个节点，另外一个任意指向后面的一个节点。复制整个链表。时间复杂度o（n），空间o（1）**
   思路：充分的利用已经空余出来的指针空间：旧指针的next和新指针的random

8 . **统计一篇文章的单词个数。注意标点符号，空格等** （思路：可以简单点，把数字和字母都作为单词的构成部分）

9 . **10亿个数字里里面找最小的10个。** （思路：找最小的，建最大堆；找最大的，建最小堆）

10 . **2亿个随机生成的无序整数,找出中间大小的值。** （找到最大和最小值，取中位数后向两端遍历查找）

11 . **给一个不知道长度的（可能很大）输入字符串，设计一种方案，将重复的字符排重。** （思路：不同字符个数是有限的，用一个临时set）

12 . **遍历二叉树。**

13 . **有3n+1个数字，其中3n个中是重复的，只有1个是不重复的，怎么找出来。** 同#3

14 . **写一个字符串（如：www.javastack.cn）反转函数。** 同前面

15 . **常用的排序算法，快排，归并、冒泡。 快排的最优时间复杂度，最差复杂度。冒泡排序的**

16 . **二分查找的时间复杂度，优势。**

17 . **一个已经构建好的TreeSet，怎么完成倒排序。**

18 . **什么是B+树，B-树，列出实际的使用场景。**

19 . **一个单向链表，删除倒数第N个数据。**

20 . **200个有序的数组，每个数组里面100个元素，找出top20的元素。**

21 . **单向链表，查找中间的那个元素。**
       
22 . **重排链表:对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3} **
23 . **将一个链表m位置到n位置之间的区间反转，要求时间复杂度o(n)，空间复杂度o(1) **
24 . **删除有序链表中重复出现的元素 **
25 . **给出一组区间，请合并所有重叠的区间
例如，
给出[1,3],[2,6],[8,10],[15,18],
返回[1,6],[8,10],[15,18].
26 . **整数列表，加起来等于某一个值的组合。如果数据量特别大，机器内存有限 **
27 . **数组中相加和为0的三元组 **

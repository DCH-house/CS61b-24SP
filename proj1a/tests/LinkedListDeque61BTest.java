import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.concurrent.DelayQueue;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

     @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
         */
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

    // Below, you'll write your own tests for LinkedListDeque61B.
    /** this test check the list if empty */
    @Test
    public void isEmptyTest(){
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
         assertThat(lld1.isEmpty()).isTrue();
    }

    /** this test check the list not empty */
    @Test
    public void isNotEmptyTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst(3);
        assertThat(lld1.isEmpty()).isFalse();
    }

    /** this test check the list when its size is zero */
    @Test
    public void sizeZeroTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.size()).isEqualTo(0);
    }

    /** this test check the list when its size is 2 */
    @Test
    public void sizeOneTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst(1);
        lld1.addLast(2);
        assertThat(lld1.size()).isEqualTo(2);
    }

    /** this test check the list when the index is negative */
    @Test
    public void negativeIndexTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(1);
        lld1.addLast(2);

        assertThat(lld1.get(-1)).isEqualTo(null);
    }

    /** this test check the list when index greater than size */
    @Test
    public void greaterThanSizeIndexTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertWithMessage("index greater than size")
                .that(lld1.get(2200)).isEqualTo(null);
    }

    /** this test check the list when index is normal with the index begin 0 */
    @Test
    public void getTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(1);
        lld1.addLast(2);

        assertThat(lld1.get(1)).isEqualTo(2);
    }

    /** this test check the list when the index is negative */
    @Test
    public void negativeIndexWithRecurTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(1);
        lld1.addLast(2);

        assertThat(lld1.getRecursive(-1)).isEqualTo(null);
    }

    /** this test check the list when index greater than size */
    @Test
    public void greaterThanSizeIndexWithRecurTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertWithMessage("index greater than size")
                .that(lld1.getRecursive(2200)).isEqualTo(null);
    }

    /** this test check the list when index is normal with the index begin 0 */
    @Test
    public void getRecurTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(1);
        lld1.addLast(2);

        assertThat(lld1.getRecursive(1)).isEqualTo(2);
    }
}
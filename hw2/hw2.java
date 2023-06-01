import java.util.Arrays;

public class hw2 {

  public static void main(String[] args) {
    int[] arr1 = { 6, 6, 10, 7, 7, 3, 4, 2, 8 };
    int k = 10;

    countsort(arr1, k);
    System.out.println(Arrays.toString(arr1));
  }

  public static void countsort(int[] arr1, int k) {
    int[] arr2 = new int[arr1.length];
    int[] diap = new int[k + 1];

    for (int i : arr1) {
      diap[i]++;
    }

    int total = 0;
    for (int i = 0; i < k + 1; i++) {
      int oldCount = diap[i];
      diap[i] = total;
      total += oldCount;
    }

   
    for (int i : arr1) {
      arr2[diap[i]] = i;
      diap[i]++;
    }

    Arrays.setAll(arr1, i -> arr2[i]);
  }

}

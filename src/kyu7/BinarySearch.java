public class BinarySearch {
    public static long findNextSquare(long sq) {
        long result = findSQR(sq);
        if(result * result == sq){
            return (result + 1) * (result + 1);
        }
        return -1;
    }
    public static long findSQR(final long sq){

        long left = 0;
        long right = sq;
        long midl = (left + right) / 2;
        long template = sq;
        for (;;) {
            midl = (left + right) / 2;

            if (midl == template || midl * midl == sq) break;

            if (midl * midl < sq){ left = midl;

            }else {
                right = midl;
            }
            template = midl;
        }
        return midl;
    }
//   public static long findNextSquare(long sq) {
//       long result = (long) Math.sqrt(sq);
//       return (result%2 == 0) ? -1 : (result + 1) * (result + 1);
//   }
}
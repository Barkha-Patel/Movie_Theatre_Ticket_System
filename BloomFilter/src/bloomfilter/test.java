package bloomfilter;

import java.util.BitSet;
    import java.util.Random;

    public class test {

        private final BitSet bs;

        final int [] hashSeeds;

        final int capacity;

        public test(int slots, int hashFunctions) {
            bs = new BitSet(slots);
            Random r = new Random(System.currentTimeMillis());
            hashSeeds = new int[hashFunctions];
            for (int i=0; i<hashFunctions; ++i) {
                hashSeeds[i] = r.nextInt();
            }
            capacity = slots;
        }

        public void add(int value) {
            byte [] b = new byte[] {
                    (byte)(value >>> 24),
                    (byte)(value >>> 16),
                    (byte)(value >>> 8),
                    (byte)value};
            for (int i=0; i<hashSeeds.length; ++i) {
                int h = MurmurHash.hash32(b, 4, hashSeeds[i]);
                bs.set(Math.abs(h)%capacity, true);
            }
        }

        public void clear() {
            bs.clear();
        }

        public boolean mightContain(int value) {
            byte [] b = new byte[] {
                    (byte)(value >>> 24),
                    (byte)(value >>> 16),
                    (byte)(value >>> 8),
                    (byte)value};
            for (int i=0; i<hashSeeds.length; ++i) {
                int h = MurmurHash.hash32(b, 4, hashSeeds[i]);

                if(!bs.get(Math.abs(h)%capacity)) {
                    return false;


            }
            }

            return true;
        }


        public static void main(String [] args) {
            test bf = new test(1000, 10);
            System.out.println("Query for 2000: " + bf.mightContain(2000));
            System.out.println("Adding 2000");
            bf.add(2000);
            System.out.println("Query for 2000: " + bf.mightContain(2000));

 System.out.println("A:  1  2  3  4  5  6  7  8  9 10");
            System.out.println("B: 11 12 13 14 15 16 17 18 19 20");
            System.out.println("C: 21 22 23 24 25 26 27 28 29 30");
            System.out.println("D: 31 32 33 34 35 36 37 38 39 40");
            System.out.println("E: 41 42 43 44 45 46 47 48 49 50");
        }
    }
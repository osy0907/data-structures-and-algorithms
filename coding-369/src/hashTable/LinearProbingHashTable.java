package hashTable;

import java.util.Objects;

public class LinearProbingHashTable {
    public Slot[] hashTable;

    public LinearProbingHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (Objects.equals(this.hashTable[address].key, key)) {
                this.hashTable[address].value = value;
            } else {
                int currAddress = address;
                while (this.hashTable[currAddress] != null) {
                    if (Objects.equals(this.hashTable[currAddress].key, key)) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
            }
            return true;
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (Objects.equals(this.hashTable[address].key, key)) {
                return this.hashTable[address].value;
            } else {
                int currAddress = address;
                while (this.hashTable[currAddress] != null) {
                    if (Objects.equals(this.hashTable[currAddress].key, key)) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

   public static void main(String[] args) {
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable(20);
        System.out.println(linearProbingHashTable.saveData("Osy", "01099997777"));
        System.out.println(linearProbingHashTable.saveData("Side", "01012345678"));
        System.out.println(linearProbingHashTable.saveData("OsyG", "01077779999"));
        System.out.println(linearProbingHashTable.saveData("OsySy", "01088886666"));
        System.out.println(linearProbingHashTable.getData("Osy"));
    }
}

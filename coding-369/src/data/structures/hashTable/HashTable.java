package data.structures.hashTable;

import org.jetbrains.annotations.NotNull;

// No Collision
public class HashTable {
    public Slot[] hashTable;

    public HashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public int hashFunc(@NotNull String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(20);
        System.out.println(hashTable.saveData("Osy", "01099997777"));
        System.out.println(hashTable.saveData("syO", "01088886666"));
        System.out.println(hashTable.getData("Osy"));
    }
}

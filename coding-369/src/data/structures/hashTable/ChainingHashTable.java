package data.structures.hashTable;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ChainingHashTable {
    public Slot[] hashTable;

    public ChainingHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public int hashFunc(@NotNull String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                if (Objects.equals(findSlot.key, key)) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (Objects.equals(findSlot.key, key)) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        }
        return null;
    }

    public static class Slot {
        String key;
        String value;
        Slot next;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ChainingHashTable chainingHashTable = new ChainingHashTable(20);
        System.out.println(chainingHashTable.saveData("Osy", "01099997777"));
        System.out.println(chainingHashTable.saveData("Side", "01012345678"));
        System.out.println(chainingHashTable.saveData("OsyG", "01077779999"));
        System.out.println(chainingHashTable.saveData("OsySy", "01088886666"));
        System.out.println(chainingHashTable.getData("Osy"));
    }
}

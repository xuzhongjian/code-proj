package com.xuzhongjian;

/**
 * @author zjxu97 at 4/23/21 10:23 PM
 */
class Trie {

    boolean isEnd = false;
    private Trie[] tries = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0) {
            this.isEnd = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        this.tries[index] = new Trie();
        Trie nextTrie = tries[index];

        nextTrie.insert(word.substring(1));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0) return this.isEnd;
        int index = word.charAt(0) - 'a';

        // 没有这个字符的插入记录
        Trie nextTire = tries[index];
        if (nextTire == null) return false;

        return nextTire.search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;

        int index = prefix.charAt(0) - 'a';

        // 没有这个字符的插入记录
        Trie nextTire = tries[index];
        if (nextTire == null) return false;

        return nextTire.startsWith(prefix.substring(1));
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println();
        boolean search = trie.search("apple");
        boolean startsWith = trie.startsWith("app");
        String substring = "a".substring(1);
        System.out.println();
    }
}
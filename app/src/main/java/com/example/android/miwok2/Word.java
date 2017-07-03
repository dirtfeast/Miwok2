package com.example.android.miwok2;

public class Word {

    private String mMiwokWord;
    private String mEnglishWord;
    private int mImageResourceId;
    private int mRawResourceId;

    // Constructor setter method
    // @params strings miwokWord and englishWord, int rawResourceId
    // Sets private strings mMiwokWord and mEnglishWord
    public Word(String miwokWord, String englishWord, int rawResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mRawResourceId = rawResourceId;
    } // Close method Word()

    // Constructor setter method, overloaded
    // Extra @param imageResourceId
    public Word(String miwokWord, String englishWord, int imageResourceId, int rawResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mImageResourceId = imageResourceId;
        mRawResourceId = rawResourceId;
    } // Close method Word()

    // Getter method to retrieve private string mMiwokWord
    public String getmMiwokWord() {
        return mMiwokWord;
    }

    // Getter method to retrieve private string mEnglishWord
    public String getmEnglishWord() {
        return mEnglishWord;
    }

    // Getter method to retrieve res ID for icon image resource;
    public int getmImageResourceId() { return mImageResourceId; }

    // Getter method to retrieve res ID for mp3 resource;
    public int getmRawResourceId() { return mRawResourceId; }

} // Close class Word

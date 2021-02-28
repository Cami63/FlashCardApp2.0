package com.example.flashcard.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class FlashcardSetContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<FlashcardSet> ITEMS = new ArrayList<FlashcardSet>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, FlashcardSet> ITEM_MAP = new HashMap<String, FlashcardSet>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummySet(i));
        }
    }

    private static void addItem(FlashcardSet item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.setId, item);
    }

    private static FlashcardSet createDummySet(int position) {
        return new FlashcardSet(String.valueOf(position), "Set #" + position);
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class FlashcardSet {
        public final String setId;
        public final String setName;

        /**
         * An array of sample (dummy) items.
         */
        public static final List<FlashcardItem> ITEMS = new ArrayList<FlashcardItem>();

        /**
         * A map of sample (dummy) items, by ID.
         */
        public static final Map<String, FlashcardItem> ITEM_MAP = new HashMap<String, FlashcardItem>();

        public FlashcardSet(String id, String name) {
            this.setId = id;
            this.setName = name;
        }

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createDummyItem(i));
            }
        }

        private static void addItem(FlashcardItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        private static FlashcardItem createDummyItem(int position) {
            return new FlashcardItem(String.valueOf(position), "Card #" + position, makeDetails(position));
        }

        private static String makeDetails(int position) {
            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore details information here.");
            }
            return builder.toString();
        }

        @Override
        public String toString() {
            return setId;
        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class FlashcardItem {
        public final String id;
        public final String front;
        public final String back;

        public FlashcardItem(String id, String front, String back) {
            this.id = id;
            this.front = front;
            this.back = back;
        }

        @Override
        public String toString() {
            return id + "~" + front + "~" + back;
        }
    }
}
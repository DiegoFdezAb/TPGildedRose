package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // // This is the original code
    
    /* 
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality--;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality++;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality--;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }            
    */

    // // This is the factored code

    public void updateQuality() {
        for (Item item: items) {
            switch(item.name) {
                case "Aged Brie":
                    updateQualityForAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateQualityForBackstagePasses(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    updateQualityForOtherItem(item);
                    break;
            }
        }
    }

    private void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
                item.quality++;
        }
    }

    private void updateQualityForBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 6 && item.quality < 50) {
                    item.quality = item.quality + 2;
            }
            else if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateQualityForOtherItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
        }
    }
}
             
      
    
    

    

    

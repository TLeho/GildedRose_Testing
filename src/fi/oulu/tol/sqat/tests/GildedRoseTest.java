package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	
	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	@Test
	public void testInstance() {
		
		GildedRose gRose = new GildedRose();
		
		gRose.main(null);
		assertFalse(GildedRose.items.isEmpty());	
	}
	
	@Test
	public void testNewItem() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("testiesine", -1, -1));
		GildedRose.updateQuality();	
			
		assertEquals("testiesine doesn't exist", "testiesine".equals(GildedRose.items.get(6).getName()) , true);
	}
	
	@Test
	public void testNewItem__NegativeSellIn_Quality10() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("testiesine", -1, 10));
		GildedRose.updateQuality();	
			
		assertEquals("testiesine quality not correct", GildedRose.items.get(6).getQuality() , 8);
	}
	
	@Test
	public void testAgedBrie_NegativeSellIn_Quality30() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Aged Brie", -1, 30));
		GildedRose.updateQuality();	
			
		assertEquals("Aged Brie wrong quality", GildedRose.items.get(6).getQuality(), 32);	
	}
	
	@Test
	public void testAgedBrie_NegativeSellIn_Quality49() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Aged Brie", -1, 49));
		GildedRose.updateQuality();	
			
		assertEquals("Aged Brie quality should cap at 50", GildedRose.items.get(6).getQuality(), 50);
	}
	
	@Test
	public void testAgedBrie_SellIn0_Quality51() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Aged Brie", 0, 51));
		GildedRose.updateQuality();	
			
		assertEquals("Aged Brie quality should not change", GildedRose.items.get(6).getQuality(), 51);
	}
	
	@Test
	public void testBackstagePass_NegativeSellIn_QualityMinusTen() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, -10));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), 0);
	}
	
	@Test
	public void testBackstagePass_SellIn11_Quality48() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), 50);
	}
	
	@Test
	public void testBackstagePass_SellIn5_Quality48() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), 50);
	}
	
	@Test
	public void testSulfuras_NegativeSellIn_Quality30() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 30));
		GildedRose.updateQuality();	
			
		assertEquals("Sulfuras quality not correct", GildedRose.items.get(6).getQuality(), 30);
	}	
	
	
	// Added for loop testing
	
	@Test
	public void testLoopNoPasses() {
		
		GildedRose.main(null);
		GildedRose.items.clear();
		
		assertEquals("List isn't empty", GildedRose.items.isEmpty(), true );	
	}
	
	// Added for mutation testing
	
	@Test
	public void testBackstagePass_SellIn6_QualityMinusTen() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, -10));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), -8);
	}
	
	@Test
	public void testBackstagePass_SellIn11_Quality40() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), 41);
	}
		
	@Test
	public void testAgedBrie_SellIn0_Quality1() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Aged Brie", 0, 1));
		GildedRose.updateQuality();	
			
		assertEquals("Aged Brie quality not correct", GildedRose.items.get(6).getQuality(), 3);
	}
		
	@Test
	public void testAgedBrie_SellInMinusOne_Quality50() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Aged Brie", -1, 50));
		GildedRose.updateQuality();	
			
		assertEquals("Aged Brie quality not correct", GildedRose.items.get(6).getQuality(), 50);
	}
	
	@Test
	public void testBackstagePass_SellIn5_Quality30() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), 33);
	}
	
	@Test
	public void testBackstagePass_SellIn1_Quality30() {
		
		GildedRose.main(null);
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30));
		GildedRose.updateQuality();	
			
		assertEquals("Backstage pass quality not correct", GildedRose.items.get(6).getQuality(), 33);
	}
	
	@Test
	public void testNewItem_SellIn0_Quality0() {
		
		GildedRose.main(null);
		
		
		GildedRose.items.add(new Item("testiesine", 0, 0));
		GildedRose.updateQuality();	
			
		assertEquals("testiesine quality not correct", GildedRose.items.get(6).getQuality() , 0);
	}
	
	
	@Test
	public void testUpdateQuality() {
		
		GildedRose.main(null);
					
		assertEquals("Dexterity vest quality not correct", GildedRose.items.get(0).getQuality(), 19);
	}
		
	
}

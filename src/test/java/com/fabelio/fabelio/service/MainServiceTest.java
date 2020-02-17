package com.fabelio.fabelio.service;

import com.fabelio.fabelio.pojo.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MainServiceTest {

	@Autowired
	private MainService mainService;

	@Test
	void getFabelioProductData() throws IOException {
		Product product = mainService.getFabelioProductData("https://fabelio.com/ip/meja-makan-cessi-new.html");
		assertEquals("Meja Makan Cessi - Glass Top", product.getProductName());
		assertEquals(new BigDecimal(699300), product.getPrice());
		assertEquals("Hangatkan Momen Bersantap Bersama Bersantap dengan keluarga membutuhkan meja yang sanggup memenuhi seluruh rangkaian menu favorit setiap anggota. Meja Makan Cessi menyediakan solusi tempat yang lapang untuk menempatkan seluruh hidangan dengan minimalis, namun tidak menjauhkannya dari kepuasan estetik. Dengan table top yang terbuat dari kaca, Meja Makan Cessi menjadi lebih terlihat modern. Dari sarapan pagi hingga makan es krim di minggu siang, semuanya menjadi sedikit lebih seru dan semangat dengan Cessi Dining Table.", product.getDescription());
		assertNotNull(product.getImages());
	}

	@Test
	void getFabelioProductData2() throws IOException {
		Product product = mainService.getFabelioProductData("https://fabelio.com/ip/meja-samping-tromso.html");
		assertEquals("Meja Samping Tromso", product.getProductName());
		assertEquals(new BigDecimal(499000), product.getPrice());
		assertEquals("Dominasi Putih untuk Tampilan Ruangan yang Lebih Lapang Tahukah kamu bahwa penggunaan warna putih dapat memberikan kesan ruangan yang lebih lapang? Bagi kamu yang tak ingin kamar tidur terasa penuh dan sempit, Tromso Side Table adalah solusi terbaik. Meja sudut ini menonjolkan finishing warna putih dengan efek kilap yang membuatnya terlihat elegan. Mengusung konsep kontemporer, Tromso Side Table berhasil menghadirkan kekokohan furnitur dengan desain yang cantik dipandang. Apalagi bagi hunian bergaya Skandinavia, tampilan meja yang minimalis membuat ruangan Anda kian berkelas. Jangan lupakan pula faktor pemilihan material kayu yang membuatnya tahan lama.  NB: Untuk produk yang memerlukan perakitan, akan dilakukan beberapa hari setelah produk dikirim. Apabila telah melebih dari 7 (tujuh) hari setelah produk dikirim belum ada tim kami yang menghubungi jadwal perakitan, Mohon segera hubungi tim Customer Service kami.", product.getDescription());
		assertNotNull(product.getImages());
	}
}
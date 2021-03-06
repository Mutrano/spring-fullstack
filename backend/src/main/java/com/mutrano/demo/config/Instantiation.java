package com.mutrano.demo.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mutrano.demo.domain.Address;
import com.mutrano.demo.domain.BoletoPayment;
import com.mutrano.demo.domain.Category;
import com.mutrano.demo.domain.City;
import com.mutrano.demo.domain.Client;
import com.mutrano.demo.domain.CreditCardPayment;
import com.mutrano.demo.domain.Order;
import com.mutrano.demo.domain.OrderItem;
import com.mutrano.demo.domain.Payment;
import com.mutrano.demo.domain.Product;
import com.mutrano.demo.domain.State;
import com.mutrano.demo.domain.enums.ClientType;
import com.mutrano.demo.domain.enums.PaymentState;
import com.mutrano.demo.repositories.AddressRepository;
import com.mutrano.demo.repositories.CategoryRepository;
import com.mutrano.demo.repositories.CityRepository;
import com.mutrano.demo.repositories.ClientRepository;
import com.mutrano.demo.repositories.OrderItemRepository;
import com.mutrano.demo.repositories.OrderRepository;
import com.mutrano.demo.repositories.PaymentRepository;
import com.mutrano.demo.repositories.ProductRepository;
import com.mutrano.demo.repositories.StateRepository;

@Profile("test")
@Configuration
public class Instantiation implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	private StateRepository stateRepository;
	private CityRepository cityRepository;
	private ClientRepository clientRepository;
	private AddressRepository addressRepository;
	private OrderRepository orderRepository;
	private PaymentRepository paymentRepository;
	private OrderItemRepository orderItemRepository;

	public Instantiation(CategoryRepository categoryRepository, ProductRepository productRepository,
			StateRepository stateRepository, CityRepository cityRepository, ClientRepository clientRepository,
			AddressRepository addressRepository, OrderRepository orderRepository, PaymentRepository paymentRepository,
			OrderItemRepository orderItemRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.stateRepository = stateRepository;
		this.cityRepository = cityRepository;
		this.clientRepository = clientRepository;
		this.addressRepository = addressRepository;
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Inform??tica");
		Category cat2 = new Category(null, "Escrit??rio");
		Category cat3 = new Category(null, "Cama mesa e banho");
		Category cat4 = new Category(null, "Eletr??nicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decora????o");
		Category cat7 = new Category(null, "Perfumaria");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		Product p4 = new Product(null, "Mesa de escrit??rio", 300.00);
		Product p5 = new Product(null, "Toalha", 50.00);
		Product p6 = new Product(null, "Colcha", 200.00);
		Product p7 = new Product(null, "TV true color", 1200.00);
		Product p8 = new Product(null, "Ro??adeira", 800.00);
		Product p9 = new Product(null, "Abajour", 100.00);
		Product p10 = new Product(null, "Pendente", 180.00);
		Product p11 = new Product(null, "Shampoo", 90.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));

		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "S??o Paulo");

		City c1 = new City(null, "Uberl??ndia", est1);
		City c2 = new City(null, "S??o Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.NATURALPERSON);

		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Address e1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address e2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(e1, e2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

		Order ped1 = new Order(null, Instant.now(), cli1, e1);
		Order ped2 = new Order(null, Instant.now(), cli1, e2);

		Payment pagto1 = new CreditCardPayment(null, PaymentState.SETTLED, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new BoletoPayment(null, PaymentState.PENDING, ped2, LocalDate.parse("20/10/2017 00:00", dtf),
				null);
		ped2.setPayment(pagto2);

		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));

		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

		OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
		OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
		OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);

		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));

		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));

		orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}

package com.gmtmarbles.backend.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gmtmarbles.backend.entity.Customer;
import com.gmtmarbles.backend.entity.Sale;
import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.entity.SlabStatus;
import com.gmtmarbles.backend.repository.CustomerRepository;
import com.gmtmarbles.backend.repository.SaleRepository;
import com.gmtmarbles.backend.repository.SlabRepository;

@Component
@Profile("dev")
public class DevelopmentDataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DevelopmentDataInitializer.class);

    private final CustomerRepository customerRepository;
    private final SlabRepository slabRepository;
    private final SaleRepository saleRepository;

    public DevelopmentDataInitializer(
            CustomerRepository customerRepository,
            SlabRepository slabRepository,
            SaleRepository saleRepository) {
        this.customerRepository = customerRepository;
        this.slabRepository = slabRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        List<Customer> sampleCustomers = List.of(
                customer("Arjun Mehta", "9876543210", "arjun.mehta@example.com", "Banjara Hills, Hyderabad"),
                customer("Rhea Interiors", "9848012345", "projects@rheainteriors.in", "Jubilee Hills, Hyderabad"),
                customer("Vardhan Developers", "9908123456", "procurement@vardhandevelopers.in", "Gachibowli, Hyderabad"),
                customer("Nila Shah", "9812345678", "nila.shah@example.com", "Viman Nagar, Pune"),
                customer("Kiran Rao", "9987654321", "kiran.rao@example.com", "Madhapur, Hyderabad"),
                customer("Sapphire Buildworks", "9701234567", "orders@sapphirebuildworks.in", "Kondapur, Hyderabad"),
                customer("Ananya Desai", "9890123456", "ananya.desai@example.com", "Koregaon Park, Pune"),
                customer("Oakline Architects", "9765432109", "studio@oaklinearchitects.in", "Hitech City, Hyderabad"),
                customer("Prakash Nair", "9958123456", "prakash.nair@example.com", "Kukatpally, Hyderabad"),
                customer("Meridian Spaces", "9823456789", "purchase@meridianspaces.in", "Miyapur, Hyderabad"),
                customer("Ishita Kapoor", "9712345678", "ishita.kapoor@example.com", "Kharadi, Pune"),
                customer("Terra Homes", "9887654321", "sales@terrahomes.in", "Manikonda, Hyderabad")
        );

        Map<String, Customer> customersByEmail = new HashMap<>();
        for (Customer customer : customerRepository.findAll()) {
            customersByEmail.put(customer.getEmail(), customer);
        }
        List<Customer> newCustomers = sampleCustomers.stream()
                .filter(customer -> !customersByEmail.containsKey(customer.getEmail()))
                .toList();
        customerRepository.saveAll(newCustomers);
        for (Customer customer : newCustomers) {
            customersByEmail.put(customer.getEmail(), customer);
        }

        List<Slab> sampleSlabs = List.of(
                slab("ITM-001", "Italian Statuario Marble", "120", "72", "20", "68500", SlabStatus.AVAILABLE),
                slab("ITM-002", "Italian Statuario Marble", "118", "70", "20", "66200", SlabStatus.AVAILABLE),
                slab("CAL-001", "Calacatta Gold Marble", "120", "72", "20", "72400", SlabStatus.AVAILABLE),
                slab("CAL-002", "Calacatta Gold Marble", "116", "70", "20", "68900", SlabStatus.RESERVED),
                slab("CAL-003", "Calacatta Gold Marble", "122", "72", "20", "74600", SlabStatus.SOLD),
                slab("EMB-001", "Emperador Dark Marble", "110", "68", "18", "43800", SlabStatus.AVAILABLE),
                slab("EMB-002", "Emperador Dark Marble", "108", "70", "18", "45200", SlabStatus.USED),
                slab("ALW-001", "Alaska White Granite", "118", "72", "20", "41200", SlabStatus.AVAILABLE),
                slab("ALW-002", "Alaska White Granite", "120", "70", "20", "42500", SlabStatus.AVAILABLE),
                slab("ALW-003", "Alaska White Granite", "116", "72", "20", "40500", SlabStatus.RESERVED),
                slab("BLG-001", "Black Galaxy Granite", "120", "72", "20", "52800", SlabStatus.AVAILABLE),
                slab("BLG-002", "Black Galaxy Granite", "118", "70", "20", "50900", SlabStatus.SOLD),
                slab("BLG-003", "Black Galaxy Granite", "115", "68", "20", "48700", SlabStatus.USED),
                slab("TAN-001", "Tan Brown Granite", "120", "72", "20", "36500", SlabStatus.AVAILABLE),
                slab("TAN-002", "Tan Brown Granite", "114", "70", "20", "34900", SlabStatus.RESERVED),
                slab("TAN-003", "Tan Brown Granite", "118", "72", "20", "37200", SlabStatus.SOLD),
                slab("ABS-001", "Absolute Black Granite", "120", "72", "20", "55600", SlabStatus.SOLD),
                slab("ABS-002", "Absolute Black Granite", "116", "70", "20", "53900", SlabStatus.AVAILABLE),
                slab("RAJ-001", "Rajasthan Black Granite", "118", "72", "20", "39600", SlabStatus.AVAILABLE),
                slab("RAJ-002", "Rajasthan Black Granite", "112", "68", "20", "37400", SlabStatus.USED),
                slab("MKW-001", "Makrana White Marble", "120", "72", "18", "47200", SlabStatus.AVAILABLE),
                slab("MKW-002", "Makrana White Marble", "116", "70", "18", "45500", SlabStatus.RESERVED),
                slab("MKW-003", "Makrana White Marble", "118", "72", "18", "46800", SlabStatus.SOLD),
                slab("FOR-001", "Forest Green Marble", "110", "68", "20", "41800", SlabStatus.AVAILABLE),
                slab("FOR-002", "Forest Green Marble", "108", "70", "20", "42600", SlabStatus.USED),
                slab("ROS-001", "Rosso Verona Marble", "116", "70", "20", "57400", SlabStatus.SOLD)
        );

        Map<String, Slab> slabsByCode = new HashMap<>();
        for (Slab slab : slabRepository.findAll()) {
            slabsByCode.put(slab.getSlabCode(), slab);
        }
        List<Slab> newSlabs = sampleSlabs.stream()
                .filter(slab -> !slabsByCode.containsKey(slab.getSlabCode()))
                .toList();
        slabRepository.saveAll(newSlabs);
        for (Slab slab : newSlabs) {
            slabsByCode.put(slab.getSlabCode(), slab);
        }

        Set<Long> slabIdsWithSales = new HashSet<>();
        for (Sale existingSale : saleRepository.findAll()) {
            slabIdsWithSales.add(existingSale.getSlab().getId());
        }
        List<SaleSeed> saleSeeds = List.of(
                new SaleSeed("arjun.mehta@example.com", "CAL-003", "84500", LocalDate.of(2026, 8, 12)),
                new SaleSeed("projects@rheainteriors.in", "BLG-002", "62000", LocalDate.of(2026, 8, 11)),
                new SaleSeed("procurement@vardhandevelopers.in", "ABS-001", "67800", LocalDate.of(2026, 8, 10)),
                new SaleSeed("nila.shah@example.com", "MKW-003", "47500", LocalDate.of(2026, 8, 8)),
                new SaleSeed("orders@sapphirebuildworks.in", "ROS-001", "71400", LocalDate.of(2026, 8, 5)),
                new SaleSeed("studio@oaklinearchitects.in", "TAN-003", "48600", LocalDate.of(2026, 7, 29))
        );
        List<Sale> newSales = saleSeeds.stream()
                .map(seed -> sale(customersByEmail.get(seed.customerEmail()), slabsByCode.get(seed.slabCode()),
                        seed.salePrice(), seed.saleDate()))
                .filter(sale -> sale.getSlab().getStatus() == SlabStatus.SOLD)
                .filter(sale -> !slabIdsWithSales.contains(sale.getSlab().getId()))
                .toList();
        saleRepository.saveAll(newSales);

        logger.info("Added development sample data: {} customers, {} slabs, {} sales.",
                newCustomers.size(), newSlabs.size(), newSales.size());
    }

    private Customer customer(String name, String phone, String email, String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        return customer;
    }

    private Slab slab(String code, String material, String length, String width, String thickness,
            String purchasePrice, SlabStatus status) {
        Slab slab = new Slab();
        slab.setSlabCode(code);
        slab.setMaterial(material);
        slab.setLength(new BigDecimal(length));
        slab.setWidth(new BigDecimal(width));
        slab.setThickness(new BigDecimal(thickness));
        slab.setPurchasePrice(new BigDecimal(purchasePrice));
        slab.setStatus(status);
        return slab;
    }

    private Sale sale(Customer customer, Slab slab, String salePrice, LocalDate saleDate) {
        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setSlab(slab);
        sale.setSalePrice(new BigDecimal(salePrice));
        sale.setSaleDate(saleDate);
        return sale;
    }

    private record SaleSeed(String customerEmail, String slabCode, String salePrice, LocalDate saleDate) {
    }
}

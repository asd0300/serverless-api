package dev.benfan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.benfan.models.CrawlerNews;
import dev.benfan.models.Product;
import dev.benfan.models.ProductQueryParameter;
import dev.benfan.models.ProductRequest;
import dev.benfan.repository.ProductRepository;
import jakarta.ws.rs.NotFoundException;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class CrawlerService {
//    @Autowired
//    private ProductRepository productRepository;
//    public Product getProduct(String id){
//        return productRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Can't find product."));
//    }
//
//    public Product createProduct(ProductRequest request){
//        Product product = new Product();
//        product.setName(request.getName());
//        product.setPrice(request.getPrice());
//
//        return productRepository.insert(product);
//    }
//    public Product replaceProduct(Product request){
//        String id = request.getOldid();
//        Product oldproduct = getProduct(id);
//
//        Product product = new Product();
//        product.setId(oldproduct.getId());
//        product.setName(request.getName());
//        product.setPrice(request.getPrice());
//
//        return productRepository.save(product);
//    }
//
//    public void deleteProduct(String id){
//        productRepository.deleteById(id);
//    }
//
//    public List<Product> getProducts(ProductQueryParameter param){
//        String keyword = Optional.ofNullable(param.getKeyword()).orElse("");
//        int priceFrom = Optional.ofNullable(param.getPriceFrom()).orElse(0);
//        int priceTo = Optional.ofNullable(param.getPriceTo()).orElse(Integer.MAX_VALUE);
//
//        Sort sort = genSortingStrategy(param.getOrderBy(), param.getSortRule());
//
//        return  productRepository.findByPriceBetweenAndNameLikeIgnoreCase(priceFrom, priceTo, keyword, sort);
//    }
//
//    private Sort genSortingStrategy(String orderBy, String sortRule) {
//        Sort sort = Sort.unsorted();
//        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
//            Sort.Direction direction = Sort.Direction.fromString(sortRule);
//            sort = Sort.by(direction, orderBy);
//        }
//        return sort;
//    }
    public void StartCrawler() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url("https://www.setn.com/ViewAll.aspx?PageGroupID=7")
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .addHeader("Appid", "10102")
                .addHeader("Content-Type", "application/json")
                .addHeader("Sec-Ch-Ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .addHeader("Sec-Ch-Ua-Mobile", "?1")
                .addHeader("Sec-Ch-Ua-Platform", "\"Android\"")
                .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .build();
        Response response = client.newCall(request).execute();
        var okbody = response.body().string();
        var resultData = DataFetch(okbody);
//        return resultData;
    }

    private ArrayList<CrawlerNews> DataFetch(String okbody) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        Document doc = null;
        XPath xPath = null;
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(okbody);
        XPathFactory factory = XPathFactory.newInstance();
        xPath=factory.newXPath();
        String expression = "//div[contains(@class,\"NewsList\")]//h3[contains(@class,\"title\")]/a";
        NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
//        return flightInfoList;
        return null;
    }
}

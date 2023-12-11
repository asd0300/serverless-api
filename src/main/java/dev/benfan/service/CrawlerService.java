package dev.benfan.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public void StartCrawler() throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"head\":{\"cid\":\"03170106361347044351\",\"cver\":\"6.4.5\",\"sver\":\"6.4.5\",\"lang\":\"zh\",\"sid\":\"5\",\"syscode\":\"04\",\"auth\":null,\"pid\":\"42\",\"transactionid\":\"h20231127212024f\",\"channel\":\"MWEB\"},\"data\":{\"baseRequest\":{\"journeyType\":\"OneWay\",\"cabinType\":\"Any\",\"fromCityCode\":\"TPE\",\"toCityCode\":\"TYO\",\"outboundDate\":\"2023-11-28\",\"inboundDate\":\"2024-01-02\",\"passengers\":[{\"type\":\"Adult\",\"quantity\":1}],\"fromAirportCode\":\"\",\"toAirportCode\":\"\",\"airlineCode\":\"\",\"isDirectFlight\":false,\"resourceType\":\"Ct\"},\"outboundToken\":\"\",\"routeSearchToken\":\"\",\"union\":{\"allianceID\":\"101\",\"sid\":\"1\",\"ouid\":\"www.google.com\",\"metaSource\":\"\",\"metaTag\":null,\"metaTime\":null}}}");
        Request request = new Request.Builder()
                .url("https://www.setn.com/ViewAll.aspx?PageGroupID=7")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Appid", "10102")
                .addHeader("Content-Type", "application/json")
                .addHeader("Referer", "https://flight.eztravel.com.tw/")
                .addHeader("Sec-Ch-Ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .addHeader("Sec-Ch-Ua-Mobile", "?1")
                .addHeader("Sec-Ch-Ua-Platform", "\"Android\"")
                .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .build();
        Response response = client.newCall(request).execute();
        var okbody = response.body().string();
//        var resultData = DataFetch(okbody);
//        return resultData;
    }

//    private ArrayList<FlightInfo> DataFetch(String okbody) throws JsonProcessingException {
//        ArrayList<FlightInfo> flightInfoList = new ArrayList<FlightInfo>() {
//        };
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(okbody);
//        var ListJson = jsonNode.at("/data/routings");
//        for(JsonNode jsonNode1: ListJson){
//            FlightInfo flightInfo = new FlightInfo();
//            flightInfo.Notes = jsonNode1.get("basic").get("ticketingDesc").asText();
//            flightInfo.FeeWithTax = jsonNode1.get("price").get("averagePrice").asInt();
//            var ListJson2 = jsonNode1.get("sector");
//            for(JsonNode jsonNode2: ListJson2){
//
//                var test1 = jsonNode2.get("airline");
//                flightInfo.FlightCompany = test1.get("name").asText();
//                flightInfo.FlightNo = jsonNode2.get("flightNumber").asText();
//                flightInfo.StartTime = jsonNode2.get("goTime").get("datetime").asText();
//                flightInfo.StartTerminal = jsonNode2.get("fromAirport").get("name").asText() +" " + jsonNode2.get("fromAirport").get("terminal").asText();
//                flightInfo.ArriveTime = jsonNode2.get("toTime").get("datetime").asText();
//                flightInfo.ArriveTerminal = jsonNode2.get("toAirport").get("name").asText() +" " + jsonNode2.get("toAirport").get("terminal").asText();
//                flightInfo.DuringTime = jsonNode2.get("duration").asText();
//                flightInfo.FlightClass = jsonNode2.get("cabinTypeName").asText();
//
//                System.out.println("123");
//                flightInfoList.add(flightInfo);
//            }
//        }
//        return flightInfoList;
//    }
}

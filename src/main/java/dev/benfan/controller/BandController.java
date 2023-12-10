package dev.benfan.Band;
import com.google.gson.Gson;
import dev.benfan.models.BandInfo;
import dev.benfan.repository.BandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bands")
public class BandController {
    private  static  final Logger log = LoggerFactory.getLogger(BandController.class);

    @Autowired
    BandRepository repository;

    @PostMapping("/add")
    public BandInfo AddBand(@RequestBody String jsonString){
        System.out.println(jsonString);
        BandInfo bandInfo = new Gson().fromJson(jsonString, BandInfo.class);
        return repository.saveBand(bandInfo);
    }
    @CrossOrigin
    @GetMapping("/getall")
    public List<BandInfo> getAll(){
        System.out.println();
        return repository.GetAll();
    }
}

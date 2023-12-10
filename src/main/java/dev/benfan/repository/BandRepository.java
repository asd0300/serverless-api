package dev.benfan.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dev.benfan.models.BandInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BandRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;
    public BandInfo saveBand(BandInfo bandInfo){
        dynamoDBMapper.save(bandInfo);
        return bandInfo;
    }
    public List<BandInfo>  GetAll(){
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<BandInfo> scanResult = dynamoDBMapper.scan(BandInfo.class, scanExpression);
        return scanResult;
    }
}

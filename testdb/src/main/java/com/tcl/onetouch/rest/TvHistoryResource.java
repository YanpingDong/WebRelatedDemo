package com.tcl.onetouch.rest;

import com.tcl.onetouch.model.TvHistory;
import com.tcl.onetouch.repository.TvHistoryRepository;
import com.tcl.onetouch.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
//import javax.inject.Inject;
import javax.validation.Valid;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class TvHistoryResource {
	private final Logger log = LoggerFactory.getLogger(TvHistoryResource.class);
	
	@Resource
	private TvHistoryRepository tvHistoryRepository;
	
	/**
     * POST  /tvSetting -> Create a new tvhistory.
     */
//	@ApiOperation(value = "create tvHistory api", httpMethod = "POST", response = TvHistory.class, notes = "create tv history")
//    @ApiResponses(value = {
//            @ApiResponse(code = 400,  response = ApiError.class, message = "Data error")
//            , @ApiResponse(code = 409, message = "Duplicate Data", response = ApiError.class) 
//            , @ApiResponse(code = 410, message = "Data Format Error", response = ApiError.class) 
//            })
    @RequestMapping(value = "/tvHistory",
        method = RequestMethod.POST,//consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional
    public ResponseEntity<?> createTvHistory(@Valid @RequestBody TvHistory tvhistory) throws URISyntaxException {
        log.debug("REST request to save TvSetting : {}", tvhistory);
        try{
        	TvHistory org = tvHistoryRepository.findByUsernameAndStypeAndVtypeAndMediaId(tvhistory.getUsername(), tvhistory.getStype(), tvhistory.getVtype(), tvhistory.getMediaId());
        	if(org!=null) tvhistory.setId(org.getId());
        	TvHistory result = tvHistoryRepository.save(tvhistory);
        	return ResponseEntity.created(new URI("/api/tvhistory/" + result.getUsername()))
            .headers(HeaderUtil.createEntityCreationAlert("tvhistory", result.getUsername().toString()))
            .body(result);
        }catch(DataIntegrityViolationException e){
        	throw new CustomeHttpStatusCodeException(409,"Data error, please check the data and do not post exist data. message:"+e.getMessage());
        }
    }

//	@ApiOperation(value = "get tvHistoryByUser api", httpMethod = "GET", response = TvHistory.class, notes = "get tv historyByUser")
    @RequestMapping(value = "/tvHistory",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional
    public ResponseEntity<?> getTvHistoryByUser(@RequestParam String userId,Pageable pageable,@RequestParam(required=false) Long start) {
    	Page<TvHistory> result = null;
    	if(null==start){
    		result = tvHistoryRepository.findByUsernameOrderByTimestampDesc(userId, pageable);
    	}else{
    		Date startDate = new Date(start);
    		result = tvHistoryRepository.findByUsernameAndTimestampGreaterThanOrderByTimestampDesc(userId,startDate, pageable);
    	}
    	if(null == result){
    		throw new DataNotFoundException();
    	}
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
    /**
     * DELETE  tvHistory
     */
//    @ApiOperation(value = "delete tvHistory api", httpMethod = "DELETE", response = TvFavorites.class, notes = "delete Favorites")
    @RequestMapping(value = "/tvHistory",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<?> deleteFavorites(@RequestParam String userId, @RequestParam(required=false) Long starttime, @RequestParam(required=false) Long endtime) {
        log.debug("REST request to delete tvFavorites : {}", userId + starttime + endtime);
        List<TvHistory> m = null;
        if(null!=starttime&& null != endtime){
        	m = tvHistoryRepository.findByUsernameAndTimestampBetween(userId,new Date(starttime),new Date(endtime));
        }else{
        	m = tvHistoryRepository.findByUsername(userId);
        }
        if (m == null || m.size() < 1)
            throw new DataNotFoundException();
        tvHistoryRepository.deleteInBatch(m);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityDeletionAlert("tvHistory", userId.toString()))
                .body(null);
    }
}

package com.ict.pretzel_admin.jung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.pretzel_admin.common.Paging;
import com.ict.pretzel_admin.jung.mapper.MovieMapper;
import com.ict.pretzel_admin.vo.CastVO;
import com.ict.pretzel_admin.vo.CrewVO;
import com.ict.pretzel_admin.vo.MovieVO;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;
        
    public int movie_insert(MovieVO movieVO) {
        int res = movieMapper.movie_insert(movieVO);
        if (res < 0) {
            return 0;
        }
        return 1;
	}
    public int cast_insert(CastVO castVO) {
        int res = movieMapper.cast_insert(castVO);
        if (res < 0) {
            return 0;
        }
        return 1;
	}
    public int crew_insert(CrewVO crewVO) {
        int res = movieMapper.crew_insert(crewVO);
        if (res < 0) {
            return 0;
        }
        return 1;
	}
    public MovieVO movie_info(String movie_idx) {
        MovieVO movie_info = movieMapper.movie_info(movie_idx);
        if (movie_info != null) {
            return movie_info;
        }
        return null;
	}

    public int movie_update(MovieVO movieVO) {
        int res = movieMapper.movie_update(movieVO);
        if (res < 0) {
            return 0;
        }
        return 1;
	}
    public int movie_delete(MovieVO movieVO) {
        int res = movieMapper.movie_delete(movieVO);
        if (res < 0) {
            return 0;
        }
        return 1;
	}
    public List<MovieVO> synchro_list() {
        List<MovieVO> res = movieMapper.synchro_list();
        if (res != null) {
            return res;
        }
        return null;
	}
    public List<MovieVO> movie_list(Paging paging) {
        List<MovieVO> res = movieMapper.movie_list(paging);
        if (res != null) {
            return res;
        }
        return null;
	}
    public int movie_synchro(String movie_idx) {
        int res = movieMapper.movie_synchro(movie_idx);
        if (res < 0) {
            return 0;
        }
        return 1;
    }
    public List<MovieVO> search_list(Paging paging) {
        List<MovieVO> res = movieMapper.search_list(paging);
        if (res != null) {
            return res;
        }
        return null;
	}
    public int search_count(String keyword) {
        int res = movieMapper.search_count(keyword);
        if (res < 0) {
            return 0;
        }
        return res;
    }
    public int movie_count() {
        int res = movieMapper.movie_count();
        if (res < 0) {
            return 0;
        }
        return res;
    }
    public List<CastVO> cast_list(String movie_idx) {
        List<CastVO> result = movieMapper.cast_list(movie_idx);
        if (result != null) {
            return result;
        }
        return null;
	}
    public int emotion_insert(String movie_idx) {
        int result = movieMapper.emotion_insert(movie_idx);
        if (result > 0) {
            return result;
        }
        return 0;
	}
    public int deepface_insert(String movie_idx) {
        int result = movieMapper.deepface_insert(movie_idx);
        if (result > 0) {
            return result;
        }
        return 0;
	}
}

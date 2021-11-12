package com.vensk.sweater.repos;

import com.vensk.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepos extends CrudRepository<Message, Integer> {
}

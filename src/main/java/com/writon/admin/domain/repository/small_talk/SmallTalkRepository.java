package com.writon.admin.domain.repository.small_talk;

import com.writon.admin.domain.entity.small_talk.SmallTalk;
import com.writon.admin.domain.entity.small_talk.SmallTalkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmallTalkRepository extends JpaRepository<SmallTalk, SmallTalkId> {

}
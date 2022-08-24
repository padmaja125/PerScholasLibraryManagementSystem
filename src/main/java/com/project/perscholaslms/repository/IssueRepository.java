package com.project.perscholaslms.repository;


import com.project.perscholaslms.models.Issue;
import com.project.perscholaslms.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	public List<Issue> findByReturned(Integer returned);
	public Long countByMemberAndReturned(Member member, Integer returned);
}

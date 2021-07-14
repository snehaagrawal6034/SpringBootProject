package io.javabrains.springbootstarter.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        // return topics;
        List<Topic> topics = new ArrayList<>();

        /* Classic way */

        // for (Topic topic : topicRepository.findAll()) {
        // topics.add(topic);
        // }

        /* Lambda way -> but here forEach accepts Consumer which doesnt return any value , so cant use */

        //topicRepository.findAll().forEach(topic -> topics.add(topic));

        /* Method Reference way */
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
       topicRepository.delete(id);
    }

    /* Without JPA */

//    List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Spring","Spring  framework","Spring framework description"),
//            new Topic("Java","Java  framework","Java framework description"),
//            new Topic("JS","JS  framework","JS framework description")));

//    public List<Topic> getAllTopics(){
//        return topics;
//    }
//
//    public Topic getTopic(String id){
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
//    }
//
//    public void addTopic(Topic topic) {
//        topics.add(topic);
//    }
//
//    public void updateTopic(String id, Topic topic) {
//        for(int i=0;i<topics.size();i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
//    }

//    public void deleteTopic(String id) {
//        for(int i=0;i<topics.size();i++){
//            topics.removeIf(t->t.getId().equals(id));
//        }
//    }
}

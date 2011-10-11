require 'bundler/setup'
require 'test/unit'
require "shoulda"
# require "./lib/queue"
require "resque"
require 'class_loader'
autoload_path './lib'

class ResqueImplTest < Test::Unit::TestCase
  
  # context "should act like Redis from a Queue-like factory" do  
  #     should "not be null" do  
  #       queue = Queue.create(:resque, "prod_android_build_events")      
  #       assert_not_nil queue
  #     end
  #   end
  
  
  # what's placed on the queue is a JSON document with a class field and args
  # redis 127.0.0.1:6379> LINDEX "resque:queue:prod_android_build_events" 0
  # "{\"class\":\"LegacyMessageProcessorWrapper\",\"args\":[\"this is a test message\"]}"
  
  context "should push messages on a queue" do  
    should "act like a normal queue w/push" do  
      # queue = Queue.create(:resque, "prod_android_build_events")      
      #      queue.push("this is a test message")
      #      
      #      sleep 3
      #      
      queues = "prod_android_build_events"
      
      # queues = "prod_log_events"
      
      worker = Resque::Worker.new(queues)
      worker.work(5)
      
      
    end
  end
  
end
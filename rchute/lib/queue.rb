require 'bundler/setup'
require 'class_loader'
autoload_path './lib'

class Queue
  

  def self.create type, queue_name
  case type 
    when :sqs
      SQSQueueImpl.new(queue_name)
    when :resque
      ResqueImpl.new(queue_name)
    else
      raise "Bad type: #{type}" 
    end
  end
  
end


# class ResqueImpl < Queue
#   
#   def initialize(queue_name)
#     @queue = queue_name
#   end
#   
#   def push
#     puts "push!"
#   end
#   
# end
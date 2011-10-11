require 'bundler/setup'
# require "./lib/queue.rb"
# require "./lib/legacy_message_processor_wrapper"
require "resque"

class ResqueImpl < Queue
  
  def initialize(queue_name)
    @queue = queue_name
  end
  
  def push(message)

    queue =  @queue

    if Object.const_defined? "DynamicClazz"
      klass = Object.const_get("DynamicClazz")
    else
      klass = Object.const_set("DynamicClazz", Class.new)
    end
    
    klass.define_singleton_method(:queue) do
      return queue
    end
    
    Resque.enqueue(klass, message)
  end
  
end
class DynamicClazz
  
  def initialize(queue)
    @queue = queue
  end
  
  def to_s
    return self.class.name
  end
  
end
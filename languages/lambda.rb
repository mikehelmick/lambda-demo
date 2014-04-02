# Ruby example of lambdas

doubleIt = lambda { |x| x * 2 }

x = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
puts x.inspect
x.map!(&doubleIt)
puts x.inspect

# Ruby also supports blocks, so this can be done inline
x.map! { |y| y * 2 }
puts x.inspect

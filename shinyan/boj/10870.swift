let n = Int(readLine()!)!

func fibonacci(_ n:Int) -> Int{
    if n<2 {
        return n
    }

    return fibonacci(n-1) + fibonacci(n-2)
    
}

print(fibonacci(n))
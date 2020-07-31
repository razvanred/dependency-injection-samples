//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation

class Database {
    
    private var accounts = [String: Account]()
    
    func getAccount(username: String) -> Account {
        return accounts.computeIfAbsent(key: username, ifAbsent: Account.init)
    }
}

class Account {
    let username: String
    private(set) var balance: Decimal = Decimal.zero
    
    init(username: String) {
        self.username = username
    }
    
    func deposit(amount: Decimal) {
        balance += amount
    }
    
    func withdraw(amount: Decimal) {
        balance -= amount
    }
}

extension Dictionary {

    fileprivate mutating func computeIfAbsent(key: Key, ifAbsent: (_ key: Key) -> Value) -> Value {
        let optionalValue = self[key]
        
        if let value = optionalValue {
            return value
        }
        
        let value = ifAbsent(key)
        self[key] = value
        
        return value
    }
}

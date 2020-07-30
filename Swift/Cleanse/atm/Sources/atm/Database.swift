//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation

struct Database {
    
    private var accounts = [String: Account]()
    
    func getAccount(username: String) -> Account {
        return accounts.computeIfAbsent(key: username, ifAbsent: Account.init)
    }
}

struct Account {
    let username: String
    private(set) var balance: Decimal = Decimal.zero
    
    init(username: String) {
        self.username = username
    }
}

extension Dictionary {

    fileprivate func computeIfAbsent(key: Key, ifAbsent: (_ key: Key) -> Value) -> Value {
        let optionalValue = self[key]
        
        if let value = optionalValue {
            return value
        }
        
        return ifAbsent(key)
    }
}

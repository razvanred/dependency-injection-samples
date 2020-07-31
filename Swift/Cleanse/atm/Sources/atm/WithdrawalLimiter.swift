//
//  WithdrawalLimiter.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

class WithdrawalLimiter {
    
    private(set) var remainingWithdrawalLimit: Decimal
    
    init(maximumWithdrawal: TaggedProvider<MaximumWithdrawal>) {
        remainingWithdrawalLimit = maximumWithdrawal.get()
    }
    
    func recordDeposit(amount: Decimal) {
        remainingWithdrawalLimit += amount
    }
    
    func recordWithdrawal(amount: Decimal) {
        remainingWithdrawalLimit -= amount
    }
}

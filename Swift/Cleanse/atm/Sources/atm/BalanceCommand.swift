//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation

let COMMAND_KEY_BALANCE = "balance"

struct BalanceCommand : NoArgsCommand {
    
    private let outputter: Outputter
    private let account: Account
    
    init(outputter: Outputter, account: Account) {
        self.account = account
        self.outputter = outputter
    }
    
    func handle() -> Result {
        outputter.output("Your balance is: \(account.balance)")
        return Result.handled()
    }
    
    var key: String { COMMAND_KEY_BALANCE }
}

//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

struct UserCommandsRouter: Component {
    
    typealias Seed = Account
    
    typealias Scope = PerSession
    
    typealias Root = CommandRouter
    
    static func configure(binder: Binder<Scope>) {
        binder.include(module: UserCommandsModule.self)
        
        binder
            .bind()
            .sharedInScope()
            .to(factory: WithdrawalLimiter.init)
    }
    
    static func configureRoot(binder bind: ReceiptBinder<Root>) -> BindingReceipt<Root> {
        bind.to(factory: CommandRouter.init)
    }
}

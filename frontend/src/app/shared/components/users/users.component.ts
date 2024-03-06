import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'app/core/models/user';
import { UserService } from 'app/core/services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css',
})
export class UsersComponent implements OnInit {
  users: User[] = [];
  constructor(
    private route: ActivatedRoute,
    private userService: UserService
  ) {}
  ngOnInit(): void {
    this.userService.getUsers().subscribe((users) => (this.users = users));

    // console.log(JSON.stringify(this.users));
    // this.loadMembers();
  }
  loadMembers() {
    // this.competitionService
    // .getCompetition(this.code)
    // .subscribe((competition) => {
    //   this.competition = competition;
    // console log json stringified
    // console.log(JSON.stringify(this.competition.rankings));
    // console.log(this.competition.jso);
    // this.ranking = competition.ranking;
    // this.members = this.ranking.map(r => r.member);
    // });
  }
}

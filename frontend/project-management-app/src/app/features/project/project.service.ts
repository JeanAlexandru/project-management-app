import {HttpClient} from "@angular/common/http";
import {IProject, Project} from "../../../shared/model/project";
import {apiUrl} from "../../../environments/environment";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private static PROJECT_API = "/api/projects";

  constructor(private httpClient: HttpClient) { }

  // getProjects
  getProjects(project: IProject){
    return this.httpClient.get<IProject>(`${apiUrl}${ProjectService.PROJECT_API}`)
  }
  // getProjectByName
  getProjectByName(project: IProject){
    return this.httpClient.get<IProject>(`${apiUrl}${ProjectService.PROJECT_API}?name=${project.name}`)
  }
  // postProject
  postProject(project: IProject){
    return this.httpClient.post<IProject>(`${apiUrl}${ProjectService.PROJECT_API}`, project)
  }
  // updateProject
  updateProject(project: IProject){
    return this.httpClient.put<IProject>(`${apiUrl}${ProjectService.PROJECT_API}`, project)
  }
  // deleteProject
  deleteProject(project: IProject){
    return this.httpClient.delete<IProject>(`${apiUrl}${ProjectService.PROJECT_API}/${project.id}`)
  }


}
